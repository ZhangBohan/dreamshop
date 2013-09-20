Details.BillDetail = DS.Model.extend({
    name: DS.attr('string'),
    count: DS.attr('number'),
    price: DS.attr('number'),
    cost: DS.attr('number'),
    unit: DS.attr('string'),
    barCode: DS.attr('string'),

    sum: function() {
        return this.get('price') * this.get('count');
    }.property('count', 'price')
});

Details.Bill = DS.Model.extend({
    userId: DS.attr('number'),
    total: DS.attr('number'),
    details: DS.hasMany('bill-detail')
});

Details.Bill.FIXTURES = []

Details.BillDetail.FIXTURES= [
    {
        id: 1,
        name: '商品1',
        count: 1,
        price: 10,
        cost: 8,
        unit: '单位',
        barCode: 'test1'
    },
    {
        id: 2,
        name: '商品2',
        count: 1,
        price: 5.2,
        cost: 4.3,
        unit: '单位',
        barCode: 'test2'
    },
    {
        id: 3,
        name: '商品3',
        count: 3,
        price: 8.0,
        cost: 7.0,
        unit: '单位',
        barCode: 'test3'
    },
    {
        id: 4,
        name: '商品4',
        count: 1,
        price: 2,
        cost: 1,
        unit: '单位',
        barCode: 'test4'
    }
]