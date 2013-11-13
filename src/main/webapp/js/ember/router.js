Details.Router.map(function () {
    this.resource('details', { path: '/' }, function() {
    })
});

Details.DetailsRoute = Ember.Route.extend({
    model: function() {
        return this.store.find('bill-detail');
    }
});