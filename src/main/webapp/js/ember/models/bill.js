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
    }
]