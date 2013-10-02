Details.Router.map(function () {
    this.resource('bill', { path: '/' }, function() {
    })
});

Details.ApplicationRoute = Ember.Route.extend({
    model: function() {
        var store = this.get('store');
        store.pushMany('goods', $.API.getGoodsList());
    }
});

Details.BillRoute = Ember.Route.extend({
    model: function(params) {
        var store = this.get('store');
        return store.find('bill', params.bill_id);
    }
});