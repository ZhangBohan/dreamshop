Details.Goods = DS.Model.extend({
    barCode: DS.attr('string'),
    name: DS.attr('string'),
    price: DS.attr('number'),
    cost: DS.attr('number'),
    unit: DS.attr('string'),
    specification: DS.attr('string')
});

Details.Goods.FIXTURES = $.API.getGoodsList();