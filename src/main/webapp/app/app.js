/**
 * Created by ktoloc on 14.06.2016.
 */
Ext.require(['Ext.data.*', 'Ext.grid.*']);
//---доработать
Ext.define('Citizen', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'id',
        type: 'int',
        useNull: true
    }, 'name', 'price'],
    validations: [{
        type: 'length',
        field: 'name',
        min: 1
    }, {
        type: 'length',
        field: 'lastName',
        min: 1
    }, {
        type: 'length',
        field: 'lastName',
        min: 1
        }]
});

Ext.onReady(function () {

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Citizen',
        proxy: {
            type: 'rest',
            url: 'citizens',
            format: 'json',
            headers: {
                'Content-Type': 'application/json'
            },
            reader: {
                type: 'json',
                root: 'data'
            },
            writer: {
                type: 'json'
            },
            api: {
                create: 'citizens/create/',
                read: '',
                update: 'citizens/edit/',
                destroy: 'citizens/delete/'
            }
        }
    });

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 400,
        height: 300,
        frame: true,
        title: 'Citizens',
        store: store,
        columns: [{
            text: 'ID',
            width: 40,
            sortable: true,
            dataIndex: 'id'
        }, {
            text: 'Name',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'LastName',
            flex:1,
            sortable: true,
            dataIndex: 'lastName',
            field: {
                xtype: 'textfield'
            }
        }, {
            text:'Document No',
            flex:1,
            sortable:true,
            dataIndex:'documentNumber',
            field: {
                xtype: 'textfield'
            }
        }],
        dockedItems: [{
            xtype: 'toolbar',
            items: [{
                text: 'Add',
                iconCls: 'icon-add',
                handler: function () {
                    // empty record
                    store.insert(0, new Citizen());
                    rowEditing.startEdit(0, 0);
                }
            }, '-', {
                text: 'Delete',
                iconCls: 'icon-delete',
                handler: function () {
                    var selection = grid.getView().getSelectionModel().getSelection()[0];
                    if (selection) {
                        store.remove(selection);
                    }
                }
            }]
        }]
    });
});