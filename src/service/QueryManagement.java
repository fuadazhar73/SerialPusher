package service;

/**
 *
 * @author bachtiar
 */
public class QueryManagement {

    public static final String FLAG_SERIAL_DATA_UPLOADED = "UPDATE `serial_data_uploaded` SET `uploaded`= 1 WHERE `ID` = ?";

    public static final String SELECT_ALL_SERIAL_DATA_QUEUE = " SELECT `ID`, `uploaded`, `ID_start`, "
            + "`ID_end`, `data_state`, `ticket_no`, `start`, `finish`, `start_count`, `start_count_uom`, "
            + "`end_count`, `end_count_uom`, `gross_deliver`, `gross_deliver_uom`, `avg_flow_rate`, "
            + "`avg_flow_rate_uom`, `after_avg_flow_rate`, `sale_number`, `meter_number`, `unit_id`, "
            + "`duplicate`, `other_one`, `other_two`, `other_three`, `other_four`, `other_five` "
            + "FROM `serial_data_queue` WHERE `uploaded` = 0 ORDER BY ID ASC";

    public static final String SELECT_ALL_SERIAL_DATA_UPLOADED = "SELECT `uploaded`, `site_id`,"
            + " `ID_start`, `ID_end`, `data_state`, `ticket_no`, `start`, `finish`, `start_count`, "
            + "`start_count_uom`, `end_count`, `end_count_uom`, `gross_deliver`, `gross_deliver_uom`, "
            + "`avg_flow_rate`, `avg_flow_rate_uom`, `after_avg_flow_rate`, `sale_number`, `meter_number`, "
            + "`unit_id`, `duplicate`, `other_one`, `other_two`, `other_three`, `other_four`, `other_five` "
            + "FROM `serial_data_uploaded` WHERE `uploaded` = 0 ";

    public static final String SELECT_TABLE_TO_UPLOAD = "SELECT `ID`, `uploaded`, `site_id`, `ID_start`, `ID_end`, "
            + "`data_state`, `ticket_no`, `start`, `finish`, `start_count`, `start_count_uom`, `end_count`, "
            + "`end_count_uom`, `gross_deliver`, `gross_deliver_uom`, `avg_flow_rate`, `avg_flow_rate_uom`, "
            + "`after_avg_flow_rate`, `sale_number`, `meter_number`, `unit_id`, `duplicate`, `other_one`, "
            + "`other_two`, `other_three`, `other_four`, `other_five` "
            + "FROM `serial_data_uploaded` WHERE `uploaded` = 0";
}
