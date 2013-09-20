Details.Goods = DS.Model.extend({
    barCode: DS.attr('string'),
    name: DS.attr('string'),
    price: DS.attr('number'),
    cost: DS.attr('number'),
    unit: DS.attr('string'),
    specification: DS.attr('string')
});

Details.Goods.FIXTURES = [
    {
        id: 1,
        name: '商品1',
        price: 10,
        cost: 8,
        barCode: "test1",
        unit: "单位",
        specification: "规格"
    },
    {
        id: 2,
        name: '商品2',
        price: 5.2,
        cost: 4.3,
        barCode: "test2",
        unit: "单位",
        specification: "规格"
    },
    {
        id: 3,
        name: '商品3',
        price: 8.0,
        cost: 7.0,
        barCode: "test3",
        unit: "单位",
        specification: "规格"
    },
    {
        id: 4,
        name: '商品4',
        price: 2,
        cost: 1,
        barCode: "test4",
        unit: "单位",
        specification: "规格"
    }
]