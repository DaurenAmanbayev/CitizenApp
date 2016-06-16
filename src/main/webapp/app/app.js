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
    }, 'name', 'lastName','birthDate', 'homeAddress', 'documentNumber', 'documentType',
        'documentCreatedDate', 'documentExpiredDate'],
    /*валидация данных*/
    validations: [{
        type: 'length',
        field: 'name',
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
    /*Панель таблица*/
    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 600,
        height: 400,
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
            width: 80,
            sortable: true,
            dataIndex: 'name',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'LastName',
            flex:1,
            width: 80,
            sortable: true,
            dataIndex: 'lastName',
            field: {
                xtype: 'textfield'
            }
        }, {
            header:'Birthday',
            xtype:'datecolumn',
            width: 90,
            sortable:true,
            dataIndex:'birthDate',
            editor: {
                xtype: 'datefield',
                allowBlank: true,
                format: 'm/d/Y',
            }
        }, {
            header: 'Address',
            flex:1,
            width: 80,
            sortable: true,
            dataIndex: 'homeAddress',
            field: {
                xtype: 'textfield'
            }
        },{
            header: 'Doc No',
            flex:1,
            width: 80,
            sortable: true,
            dataIndex: 'documentNumber',
            field: {
                xtype: 'textfield'
            }
        },{
            header: 'Doc Type',
            flex:1,
            width: 80,
            sortable: true,
            dataIndex: 'documentType',
            field: {
                xtype: 'textfield'
            }
        },{
            header: 'Doc Create',
            xtype:'datecolumn',
            width: 90,
            sortable:true,
            dataIndex:'documentCreatedDate',
            editor: {
                xtype: 'datefield',
                allowBlank: true,
                format: 'm/d/Y',
            }
        },{
            header: 'Doc Expire',
            xtype:'datecolumn',
            width: 90,
            dataIndex: 'documentExpiredDate',
            editor: {
                xtype: 'datefield',
                allowBlank: true,
                format: 'm/d/Y',
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