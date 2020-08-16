package edu.neu.csye6200.model;

/**
 * Student Data Model
 * Should has these fields:
 *  - grade
 *  - walk-in date
 *  - immunization record
 *
 * @see <a href="https://www.notion.so/haotianzheng/Student-256835304927473cb082a6feabdb5d8e">Student Data On Notion</a>
 * @author Haotian Zheng
 */
public class Student extends User implements CsvSerializable
{

    @Override
    public String saveCsv() {
        return null;
    }

    @Override
    public void loadCsv() {

    }
}
