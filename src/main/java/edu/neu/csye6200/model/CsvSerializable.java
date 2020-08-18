package edu.neu.csye6200.model;

import java.util.Map;

/**
 * Interface for CSV import/export
 * @author Haotian Zheng
 */
public interface CsvSerializable {
    void saveCsv(Map<String, String> map);
    void loadCsv(Map<String, String> map);
}
