CREATE TABLE categorie (
    id INTEGER GENERATE ALWAYS AS IDENTITY,
    nom TEXT NOT NULL,
    CONSTRAINT categorie_pk PRIMARY KEY (id)
);

CREATE TABLE article (
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    titre TEXT NOT NULL,
    corps TEXT NOT NULL,
    categorie_id INTEGER NOT NULL,
    CONSTRAINT article_pk PRIMARY KEY (id),
    CONSTRAINT article_categorie_fk FOREIGN KEY (categorie_id)
        REFERENCES categorie (id)
);