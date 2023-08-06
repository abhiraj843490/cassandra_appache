package com.cassandra.demo.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("csv_model")
@Data
public class CsvModel {
    @PrimaryKey
    private String id;
    private String series_reference;
    private String period;
    private String data_value;
    private String status;
    private String units;
    private String magnitude;
    private String  subject;
    private String group;

    public CsvModel(String id, String series_reference, String period,
                    String data_value, String status, String units, String magnitude,
                    String subject, String group) {
        this.id = id;
        this.series_reference = series_reference;
        this.period = period;
        this.data_value = data_value;
        this.status = status;
        this.units = units;
        this.magnitude = magnitude;
        this.subject = subject;
        this.group = group;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeries_reference(String series_reference) {
        this.series_reference = series_reference;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setData_value(String data_value) {
        this.data_value = data_value;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getSeries_reference() {
        return series_reference;
    }

    public String getPeriod() {
        return period;
    }

    public String getData_value() {
        return data_value;
    }

    public String getStatus() {
        return status;
    }

    public String getUnits() {
        return units;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getSubject() {
        return subject;
    }

    public String getGroup() {
        return group;
    }

    public CsvModel() {

    }
}
