package com.it.app.model;

import javax.persistence.*;

// класс, где создается таблица RecommendedValue, ее столбцы и связи с другими таблицами БД
@Entity
@Table
public class RecommendedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long recommendedValue;

    @OneToOne(mappedBy = "recommendedValue")
    private Flat flats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecommendedValue() {
        return recommendedValue;
    }

    public void setRecommendedValue(Long recommendedValue) {
        this.recommendedValue = recommendedValue;
    }

    public Flat getFlats() {
        return flats;
    }

    public void setFlats(Flat flats) {
        this.flats = flats;
    }
}
