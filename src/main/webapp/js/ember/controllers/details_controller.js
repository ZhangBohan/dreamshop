Details.DetailsController = Ember.ArrayController.extend({
    actions: {

    },

    isNotDeal: false,

    totalSum: function() {
        var totalSum = 0;
        var sums = this.filterBy('sum')
        if(sums) {
            for(var i = 0; i < sums.length; i++) {
                var sum = sums[i];
                totalSum += sum.get('sum');
            }
        }
        return totalSum;
    }.property('@each.sum')
});