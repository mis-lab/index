// echarts生成散点图
let dom = document.getElementById("echarts");
let myChart = echarts.init(dom);
let app = {};
option = null;
let dataALIBB = [];
let dataYZWX= [];
let dataJD = [];
let dataZJTD=[];
let dataKDXF=[];
let dataYZ=[];
let firm=[dataALIBB,dataYZWX,dataJD,dataZJTD,dataKDXF,dataYZ];


let schema = [
    {name: 'string', index: 0, text: '公司'},
    {name: 'number', index: 1, text: '人数'},

];


let itemStyle = {
    normal: {
        opacity: 0.8,
        shadowBlur: 10,
        shadowOffsetX: 0,
        shadowOffsetY: 0,
        shadowColor: 'rgba(0, 0, 0, 0.5)'
    }
};

option = {
    backgroundColor: '#404a59',
    color: [
        '#ec6f2b','#80F1BE','#dd4444','#00a0e9','#00479d','#e26363'
    ],
    legend: {
        y: 'top',
        data: ['字节跳动','云智维新','科大讯飞','阿里巴巴','有赞','京东'],

        textStyle: {
            color: '#fff',
            fontSize: 16
        }
    },
    grid: {
        x: '10%',
        x2: 150,
        y: '18%',
        y2: '10%'
    },
    tooltip: {
        padding: 10,
        backgroundColor: '#222',
        borderColor: '#777',
        borderWidth: 1,
        formatter: function (obj) {
            let value = obj.value;
            return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
                + obj.seriesName + schema[1].text + '：' + value[1] + '<br>';
        }
    },
    xAxis: {
        type: 'category',
        name: '公司',
        nameGap: 0.5,
        nameTextStyle: {
            color: '#fff',
            fontSize: 14
        },
        data:['字节跳动','云智维新','科大讯飞','阿里巴巴','有赞','京东'],

        axisLine: {
            lineStyle: {
                color: '#eee'
            }
        }
    },
    yAxis: {
        type: 'value',
        name: '人数',
        nameLocation: 'end',
        nameGap: 1,
        nameTextStyle: {
            color: '#fff',
            fontSize: 14
        },
        axisLine: {
            lineStyle: {
                color: '#eee'
            }
        },
        max:6,
        min:0,
        splitLine: {
            show: false
        }
    },
    visualMap:[{
        left: 'right',
        top: '15%',
        dimension: 1,
        min: 0,
        max: 15,
        itemWidth: 30,
        itemHeight: 100,
        calculable: true,
        precision: 0.1,
        text: ['圆形大小：人数'],
        textGap: 30,
        textStyle: {
            color: '#fff'
        },
        inRange: {
            symbolSize: [10, 70]
        },
        outOfRange: {
            symbolSize: [10, 70],
            color: ['rgba(255,255,255,.2)']
        },
        controller: {
            inRange: {
                color: ['#c23531']
            },
            outOfRange: {
                color: ['#444']
            }
        }
    }
],
    series: [
        {
            name: '阿里巴巴',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataALIBB
        },
        {
            name: '云智维新',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataYZWX
        },
        {
            name: '京东',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataJD
        },

        {
            name: '字节跳动',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataZJTD
        },
        {
            name: '科大讯飞',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataKDXF
        },
        {
            name: '有赞',
            type: 'scatter',
            itemStyle: itemStyle,
            data: dataYZ
        },

    ]
};

//请求毕业生去向数据
const graduate=fetch('http://172.22.1.154:8888/index/graduate/jobDistribute')
      .then((response) => response.json())
      .then((responsedata) => {
        return responsedata.data;
      })
      .catch((error) => {
        console.error(error);
      });

      graduate
      .then(function(data) {
        //console.log(data);
        let graData=Object.entries(data);

        let getdata=graData.slice();
        //console.log(getdata[0]);
        dataZJTD.push(getdata[0]);
        dataYZWX.push(getdata[1]);
        dataKDXF.push(getdata[2]);
        dataALIBB.push(getdata[3]);
        dataYZ.push(getdata[4]);
        dataJD.push(getdata[5]);


        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }

       })
      .catch(function(error) {
        console.log(error);
      });

//请求发展方向数据
const end=document.getElementById('end');
const front=document.getElementById('front');
const product=document.getElementById('product');
const direction=fetch('http://172.22.1.154:8888/index/title/all', {
        method: 'GET',
        mode: 'cors',
        cache: 'default'})
      .then((response) => response.json())
      .then((responsedata) => {
        //console.log(responsedata.data);
        return responsedata.data;
      })
      .catch((error) => {
        console.error(error);
      });

  //利用promise处理
    direction
      .then(function(data) {
        const dirData=JSON.parse(JSON.stringify(data));
          end.innerHTML="<h3>"+dirData[0].titleName+"</h3>"+"<p>"+dirData[0].description+"</p>";
          front.innerHTML="<h3>"+dirData[1].titleName+"</h3>"+"<p>"+dirData[1].description+"</p>";
          product.innerHTML="<h3>"+dirData[2].titleName+"</h3>"+"<p>"+dirData[2].description+"</p>";
       })
      .catch(function(error) {
        console.log(error);
      });
