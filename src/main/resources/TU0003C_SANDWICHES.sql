create table SANDWICHES
(
    ID          NUMBER(30) not null
        constraint SANDWICHES_PK
            primary key,
    NAME        VARCHAR2(100),
    DESCRIPTION VARCHAR2(100),
    CATEGORY    VARCHAR2(100),
    BASEPRICE   FLOAT
)
/

INSERT INTO TU0003C.SANDWICHES (ID, NAME, DESCRIPTION, CATEGORY, BASEPRICE) VALUES (3, 'legumes', 'tomato greens', 'veggie', 10.8);
INSERT INTO TU0003C.SANDWICHES (ID, NAME, DESCRIPTION, CATEGORY, BASEPRICE) VALUES (1, 'poulet', 'poulet curry', 'non-veg', 12.82);
INSERT INTO TU0003C.SANDWICHES (ID, NAME, DESCRIPTION, CATEGORY, BASEPRICE) VALUES (2, 'poisson', 'salmon salade', 'non-veg', 15.82);
