CREATE TABLE Button
(
    id         INTEGER      NOT NULL,
    identification      VARCHAR(255) NOT NULL,
    name         VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES JakonObject (id) ON DELETE CASCADE
)