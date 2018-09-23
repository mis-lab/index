apis

# 方向模块

## 获取所有方向

`GET /title/`

示例数据如下：

```json
{
    "info":[
        {
            "id":1,
            "titleName":"Java 开发工程师",
            "pictureUrl":"Java.svg",
            "description":"主要负责 Web 服务端开发"
        },
        {
            "id":2,
            "titleName":"JavaScript 开发工程师",
            "pictureUrl":"JavaScript.svg",
            "description":"主要负责 Web 客户端开发"
        },
        {
            "id":3,
            "titleName":"产品经理",
            "pictureUrl":"PM.svg",
            "description":"主要负责产品设计与运营"
        }
    ]
}
```

# 毕业成员信息

## 毕业成员去向分布

`GET /graduate/jobDistribute`

示例数据如下：

```json
{
    "info":{
        "字节跳动":2,
        "云智维新":2,
        "科大讯飞":1,
        "阿里巴巴":1,
        "有赞":1,
        "京东":1
    }
}
```

# 图片

## 获取工作室图标

`/images/icon.svg`

## 获取工作室图标（经过压缩后的）

`/images/icon-small.svg`