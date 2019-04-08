package com.it.app.model;

import javax.persistence.*;
// класс, где создается таблица Contracts, ее столбцы и связи с другими таблицами БД
@Entity
@Table
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//связь с таблицей Realtor многие к одному
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realtor_id")
    private Realtor realtor;

    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void setFlats(Flat flat) {
        this.flat = flat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
