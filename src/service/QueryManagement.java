package service;

/**
 *
 * @author bachtiar
 */
public class QueryManagement {

  public static final String GETALL_SERIAL_DATA = "SELECT * FROM `serial_data` WHERE `downloaded` = 0 ";

  public static final String FLAG_SERIAL_DATA_DOWNLOADED = "UPDATE serial_data SET downloaded = 1 WHERE ID >= ? AND ID <= ?";

  public static final String FLAG_SERIAL_DATA_UPLOADED = "UPDATE `serial_data_uploaded` SET `uploaded`= 1 WHERE `ID` = ?";

  public static final String FLAG_SERIAL_DATA_QUEUED = "UPDATE `serial_data_queue` SET `uploaded`= 1 WHERE `ID` = ?";
  
    public static final String FLAG_SERIAL_CALIBRATION_UPLOADED = "UPDATE `serial_calibration_uploaded` SET `uploaded`= 1 WHERE `ID` = ?";

  public static final String FLAG_SERIAL_CALIBRATION_QUEUED = "UPDATE `serial_calibration_queued` SET `uploaded`= 1 WHERE `ID` = ?";

  public static final String INSERT_INTO_SERIAL_DATA_QUEUE = "INSERT INTO `serial_data_queue` "
          + "(`uploaded`, `ID_start`, `ID_end`, `ticket_no`, `start`, `finish`, `start_count`, `start_count_uom`, `end_count`, "
          + "`end_count_uom`, `gross_deliver`, `gross_deliver_uom`, `avg_flow_rate`, `avg_flow_rate_uom`, `after_avg_flow_rate`, `sale_number`, `meter_number`, "
          + "`unit_id`, `duplicate`, `other_one`, `other_two`, `other_three`, `other_four`, `other_five`, `data_state`) "
          + "VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public static final String INSERT_INTO_SERIAL_DATA_UPLOADED = "INSERT INTO `serial_data_uploaded`"
          + "(`uploaded`, `site_id`, `ID_start`, `ID_end`, `data_state`, `ticket_no`, `start`, `finish`, "
          + "`start_count`, `start_count_uom`, `end_count`, `end_count_uom`, `gross_deliver`, "
          + "`gross_deliver_uom`, `avg_flow_rate`, `avg_flow_rate_uom`, `after_avg_flow_rate`, "
          + "`sale_number`, `meter_number`, `unit_id`, `duplicate`, `other_one`, `other_two`, "
          + "`other_three`, `other_four`, `other_five`)"
          + "VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  public static final String INSERT_INTO_SERIAL_CALIBRATION_QUEUED = "INSERT INTO `serial_calibration_queued`(`uploaded`, `shift_start`, "
          + "`shift_finish`, `unit_id`, `cal_num`, `shift_net`, `shift_gross`, `end_net_total`, "
          + "`end_totalizer`, `deliveries`) "
          + "VALUES (0,?,?,?,?,?,?,?,?,?)";

  public static final String INSERT_INTO_SERIAL_CALIBRATION_UPLOADED = "INSERT INTO `serial_calibration_uploaded`"
          + "(`uploaded`, `shift_start`, `shift_finish`, `unit_id`, `cal_num`, `shift_net`, `shift_gross`, "
          + "`end_net_total`, `end_totalizer`, `deliveries`) "
          + "VALUES (0,?,?,?,?,?,?,?,?,?)";

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
  
  public static final String SELECT_QUEUED_CALIBRATION = "SELECT `id`, `uploaded`, `shift_start`, "
          + "`shift_finish`, `unit_id`, `cal_num`, `shift_net`, `shift_gross`, `end_net_total`, "
          + "`end_totalizer`, `deliveries` "
          + "FROM `serial_calibration_queued` WHERE `uploaded` = 0 ORDER BY id ASC";
  
  public static final String SELECT_UPLOAD_CALIBRATION = "SELECT `id`, `uploaded`, `shift_start`, "
          + "`shift_finish`, `unit_id`, `cal_num`, `shift_net`, `shift_gross`, `end_net_total`, "
          + "`end_totalizer`, `deliveries` "
          + "FROM `serial_calibration_uploaded` WHERE `uploaded` = 0 ORDER BY id ASC";

}
