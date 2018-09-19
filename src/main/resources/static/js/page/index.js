// echarts生成散点图
const dom = document.getElementById('echarts');
const myChart = echarts.init(dom);
// const app = {};
let option = null;
const dataALIBB = [];
const dataYZWX = [];
const dataJD = [];
const dataZJTD = [];
const dataKDXF = [];
const dataYZ = [];
const firm = [dataALIBB, dataYZWX, dataJD, dataZJTD, dataKDXF, dataYZ];

const schema = [
  { name: 'string', index: 0, text: '公司' },
  { name: 'number', index: 1, text: '人数' },

];

const itemStyle = {
  normal: {
    opacity: 0.8,
    shadowBlur: 10,
    shadowOffsetX: 0,
    shadowOffsetY: 0,
    shadowColor: 'rgba(0, 0, 0, 0.5)',
  },
};

option = {
  backgroundColor: '#404a59',
  color: [
    '#ec6f2b', '#80F1BE', '#dd4444', '#00a0e9', '#00479d', '#e26363',
  ],
  legend: {
    y: 'top',
    data: ['字节跳动', '云智维新', '科大讯飞', '阿里巴巴', '有赞', '京东'],

    textStyle: {
      color: '#fff',
      fontSize: 16,
    },
  },
  grid: {
    x: '10%',
    x2: 150,
    y: '18%',
    y2: '10%',
  },
  tooltip: {
    padding: 10,
    backgroundColor: '#222',
    borderColor: '#777',
    borderWidth: 1,
    formatter(obj) {
      const { value } = obj;
      return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">
                ${obj.seriesName}${schema[1].text}:${value[1]}  <br></div>`;
    },
  },
  xAxis: {
    type: 'value',
    name: 'x',
    nameGap: 16,
    nameTextStyle: {
      color: '#fff',
      fontSize: 14,
    },
    max: 8,
    splitLine: {
      show: false,
    },
    axisLine: {
      lineStyle: {
        color: '#eee',
      },
    },
  },
  yAxis: {
    type: 'value',
    name: '人数',
    nameLocation: 'end',
    nameGap: 1,
    nameTextStyle: {
      color: '#fff',
      fontSize: 14,
    },
    axisLine: {
      lineStyle: {
        color: '#eee',
      },
    },
    max: 6,
    min: 0,
    splitLine: {
      show: false,
    },
  },
  visualMap: [{
    left: 'right',
    top: '15%',
    dimension: 1,
    min: 0,
    max: 5,
    itemWidth: 30,
    itemHeight: 100,
    calculable: true,
    precision: 0.1,
    text: ['圆形大小：人数'],
    textGap: 30,
    textStyle: {
      color: '#fff',
    },
    inRange: {
      symbolSize: [10, 70],
    },
    outOfRange: {
      symbolSize: [10, 70],
      color: ['rgba(255,255,255,.2)'],
    },
    controller: {
      inRange: {
        color: ['#c23531'],
      },
      outOfRange: {
        color: ['#444'],
      },
    },
  },
  ],
  series: [
    {
      name: '阿里巴巴',
      type: 'scatter',
      itemStyle,
      data: dataALIBB,
    },
    {
      name: '云智维新',
      type: 'scatter',
      itemStyle,
      data: dataYZWX,
    },
    {
      name: '京东',
      type: 'scatter',
      itemStyle,
      data: dataJD,
    },

    {
      name: '字节跳动',
      type: 'scatter',
      itemStyle,
      data: dataZJTD,
    },
    {
      name: '科大讯飞',
      type: 'scatter',
      itemStyle,
      data: dataKDXF,
    },
    {
      name: '有赞',
      type: 'scatter',
      itemStyle,
      data: dataYZ,
    },

  ],
};


// 请求毕业生去向数据
const graduate = fetch('http://172.22.1.154:8888/index/graduate/jobDistribute', {
  method: 'GET',
  mode: 'cors',
  cache: 'default',
})
  .then(response => response.json())
  .then(responsedata => responsedata.data)
  .catch((error) => {
    console.error(error);
  });
//  利用返回的promise处理
graduate
  .then((data) => {
    const personNum = [];
    const graData = Object.entries(data);
    const getdata = graData.slice();

    for (const value of getdata) {
      const firmNum = Number.parseInt(Math.random() * 5 + 0.99999, 10);
      value.splice(0, 1, firmNum);
      personNum.push(value);
    }
    for (const i in firm) {
      if (Object.prototype.hasOwnProperty.call(firm, i)) {
        firm[i].push(personNum[i]);
      }
    }
    if (option && typeof option === 'object') {
      myChart.setOption(option, true);
    }
  })
  .catch((error) => {
    console.log(error);
  });
if (option && typeof option === 'object') {
  myChart.setOption(option, true);
}


// 请求发展方向数据
const end = document.getElementById('end');
const front = document.getElementById('front');
const product = document.getElementById('product');
const direction = fetch('http://172.22.1.154:8888/index/title/all', {
  method: 'GET',
  mode: 'cors',
  cache: 'default',
})
  .then(response => response.json())
  .then(responsedata => responsedata.data)
  .catch((error) => {
    console.error(error);
  });

// 利用返回的promise处理
direction
  .then((data) => {
    const dirData = JSON.parse(JSON.stringify(data));
    end.innerHTML = `<h3>${dirData[0].titleName}</h3> <p>${dirData[0].description}</p>`;
    front.innerHTML = `<h3>${dirData[1].titleName}</h3> <p>${dirData[0].description}</p>`;
    product.innerHTML = `<h3>${dirData[2].titleName}</h3> <p>${dirData[0].description}</p>`;
  })
  .catch((error) => {
    console.log(error);
  });
