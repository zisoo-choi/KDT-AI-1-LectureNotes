package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import lombok.Getter;

@Getter
public enum AmountType {
    GRAM("01", "GRAM"),
    COUNT("02", "COUNT"),;

    AmountType(String cd, String cdNm) {
        this.cd = cd;
        this.cdNm = cdNm;
    }

    String cd;
    String cdNm;

    void test() {
        AmountType.COUNT.getCd(); // 02
        AmountType.COUNT.getCdNm(); // COUNT
    }
}
