$(document).ready(function () {
    lineChartInit();
    pieChartInit();
})
/**
 * line Chart Init
 */
function lineChartInit() {
    var option = {
        title: {
            text: '日期分布图'
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:['成功', '失败','进行中']
        },
        toolbox: {
            feature: {
                /*saveAsImage: {}*/
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : 12
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'成功',
                type:'line',
                stack: 'Total',
                areaStyle: {normal: {}},
                data: [453,123,54]
            },
            {
                name:'失败',
                type:'line',
                stack: 'Total',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                areaStyle: {normal: {}},
                data: [321,33,123]
            },
            {
                name:'进行中',
                type:'line',
                stack: 'Total',
                areaStyle: {normal: {}},
                data: [1231,342,543]
            }
        ],
        color:['#00A65A', '#c23632', '#F39C12']
    };
    var lineChart = echarts.init(document.getElementById('lineChart'));
    lineChart.setOption(option);
}
/**
 * pie Chart Init
 */
function pieChartInit() {
    var option = {
        title : {
            text: "成功比例图" ,
            /*subtext: 'subtext',*/
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['成功','失败', '正在运行']
        },
        series : [
            {
                //name: '分布比例',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {
                        name:'成功',
                        value:6
                    },
                    {
                        name:'失败',
                        value:8
                    },
                    {
                        name:'正在运行',
                        value:6
                    }
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ],
        color:['#00A65A', '#c23632', '#F39C12']
    };
    var pieChart = echarts.init(document.getElementById('pieChart'));
    pieChart.setOption(option);
}
