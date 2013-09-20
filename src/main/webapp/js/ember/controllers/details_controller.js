Details.DetailsController = Ember.ArrayController.extend({
    actions: {

    },

    isNotDeal: false,

    totalSum: function() {
        var totalSum = 0;
        var billDetails = this.filterBy('id');
        if(billDetails) {
            for(var i = 0; i < billDetails.length; i++) {
                var billDetail = billDetails[i];
                totalSum += billDetail.get('sum');
            }
        }
        return totalSum;
    }.property('@each.id')
});