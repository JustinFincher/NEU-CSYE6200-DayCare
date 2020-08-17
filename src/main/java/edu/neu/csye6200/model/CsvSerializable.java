package edu.neu.csye6200.model;

/**
 * Interface for CSV import/export
 * @author Haotian Zheng
 */
public interface CsvSerializable {
    String saveCsv();
    void loadCsv();
}
