import mysql.connector

sql_statements = ["INSERT INTO `athena_tasks` (`name`, `description`, `athena_database`, `athena_query`, `poll_max_retries`, `poll_interval_in_ms`, `output_s3_bucket`, `output_s3_path`, `created_by`, `updated_by`, `deleted`, `watchers`, `success_event`, `is_visible`) VALUES ('Outstation SKU Orders', 'Outstation SKU Orders', 'flat_tables', \"SELECT project_id,id_order,parent_order,customer_name,sku,product_name,total_order_quantity,price_no_tax,tax_percent,mapped_quantity,po_item_id,shipment_requested_date,poitem_id_sp,poitem_id_sp_wt,mapped_discount,mapped_handling,super_category_name,sourcing_model,funnel_name,delivery_city,project_city,order_type_name\nFROM flat_tables.flat_order_items\nWhere sku IN (\'LSAOLS0024S0001\',\'LSAOLS0025S0001\')\", '10', '20000', 'modular-po-docs', 'athena', '0', '0', '0', NULL, NULL, '1')"]
dbHost = 'livspaceprod.ciq7fhve3lvr.ap-southeast-1.rds.amazonaws.com'
dbUser = 'livspace'
dbPasswd = 'livspaceadmin'
dbTable = 'oms_backend'

readdb = mysql.connector.connect(host=dbHost, user=dbUser, passwd=dbPasswd, db=dbTable, port=3306)
readcursor = readdb.cursor(buffered=True)

for sqls in sql_statements:
    print(sqls)
    readcursor.execute(sqls)
    readdb.commit()


update ps_order_detail set is_active=0 where id_order_detail=19811128;