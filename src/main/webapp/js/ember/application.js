window.Details = Ember.Application.create();
//Details.ApplicationAdapter = DS.FixtureAdapter.extend();
Details.ApplicationAdapter = DS.LSAdapter.extend({
    namespace: 'details'
});