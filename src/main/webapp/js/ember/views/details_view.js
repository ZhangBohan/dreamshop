Details.DetailsView = Em.View.extend({

    keyPress: function(e) {
        var on_settlement = $("#settlement-modal").is(":visible");
        if(on_settlement && 13 == e.keyCode) {
            this.get('controller').send('createBill');
        }
    }
});