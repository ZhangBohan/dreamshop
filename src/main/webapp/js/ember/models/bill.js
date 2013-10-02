Details.BillDetail = DS.Model.extend({
    name: DS.attr('string'),
    count: DS.attr('number'),
    price: DS.attr('number'),
    cost: DS.attr('number'),
    unit: DS.attr('string'),
    barCode: DS.attr('string'),

    sum: function() {
        var sum = this.get('price') * this.get('count');
        sum = parseFloat(sum, 10).toFixed(2);
        return sum;
    }.property('count', 'price')
});

Details.Bill = DS.Model.extend({
    total: DS.attr('number'),
    createdAt: DS.attr('date'),
    details: DS.hasMany('bill-detail')
});