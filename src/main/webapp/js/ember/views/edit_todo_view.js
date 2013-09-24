Todos.EditTodoView = Ember.TextField.extend({
    didInsertElement: function() {
        this.$().focus();
    },

    input: function() {

    }
});

Ember.Handlebars.helper('edit-todo', Todos.EditTodoView);