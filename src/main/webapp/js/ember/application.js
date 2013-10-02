window.Details = Ember.Application.create({
    LOG_TRANSITIONS: true, // basic logging of successful transitions
    LOG_TRANSITIONS_INTERNAL: true, // detailed logging of all routing steps
    ready: function() {

    }
});
//Details.ApplicationAdapter = DS.LSAdapter.extend({
//    namespace: 'details'
//});

Details.ApplicationAdapter = DS.RESTAdapter.extend({
    namespace: '/dreamshop/api'
});
