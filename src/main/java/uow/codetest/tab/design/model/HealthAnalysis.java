package uow.codetest.tab.design.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Health Data Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.17 2018
 * @since	1.0
 *
 */

@Entity(name = "MemberShip")
@Table(name = "db_user_membership")
public class HealthAnalysis extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="analysis_member")
    @JsonBackReference
    private MemberShip member;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="analysis_data")
    @JsonBackReference
    private HealthData data;


    @Column(nullable = false)
    private Date reportdate;

    public HealthAnalysis() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HealthData getData() {
        return data;
    }

    public void setData(HealthData data) {
        this.data = data;
    }

    public MemberShip getMember() {
        return member;
    }

    public void setMember(MemberShip member) {
        this.member = member;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }
}