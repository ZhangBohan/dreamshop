Todos.TodoController = Ember.ObjectController.extend({
    actions: {
        editTodo: function() {
            this.set('isEditing', true);
        },
        acceptChanges: function() {
            this.set('isEditing', false);
            this.get('model').save();
        }
    },

    isEditing: false,

    isCompleted: function(key, value) {
        var model = this.get('model');

        if(value === undefined) {
            // property being used as a getter
            return model.get('isCompleted')
        } else {
            // property being used as a setter
            model.set('isCompleted', value);
            model.save();
        }
    }.property('model.isCompleted'),

    removeTodo: function() {
        var model = this.get('model');
        model.deleteRecord();
        model.save();
    }
});