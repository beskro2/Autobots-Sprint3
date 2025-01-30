DROP TABLE IF EXISTS moons CASCADE;
DROP TABLE IF EXISTS planets CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    CONSTRAINT username_length_check CHECK (
        LENGTH(username) >= 5 AND LENGTH(username) <= 30
    ),
    CONSTRAINT password_length_check CHECK (
        LENGTH(password) >= 5 AND LENGTH(password) <= 30
    ),
    CONSTRAINT username_character_check CHECK (
        username ~ '^[a-zA-Z0-9_-]+$'
    ),
    CONSTRAINT password_character_check CHECK (
        password ~ '.*[a-z].*' AND
        password ~ '.*[A-Z].*' AND
        password ~ '.*[0-9].*' AND
        password ~ '^[a-zA-Z0-9_-]+$'
    )
);

INSERT INTO users (username, password) VALUES ('Batman', 'Iamthenight1939');
INSERT INTO users (username, password) VALUES ('BatmanUser2', 'Iamthenight1900');

CREATE TABLE planets (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    ownerId INTEGER NOT NULL,
    image BYTEA,
    description TEXT,
    FOREIGN KEY (ownerId) REFERENCES users(id) ON DELETE RESTRICT,
    CONSTRAINT name_length_check CHECK (LENGTH(name) <= 30),
    CONSTRAINT name_character_check CHECK (
        name ~ '^[a-zA-Z0-9_ -]+$'
    )
);

INSERT INTO planets (name, ownerId, image, description) VALUES ('Earth', 1, ?, 'Four seasons year round');
INSERT INTO planets (name, ownerId, image) VALUES ('Mars', 1, ?);
INSERT INTO planets (name, ownerId, image) VALUES ('Saturn', 2, ?);

CREATE TABLE moons (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    myPlanetId INTEGER NOT NULL,
    image BYTEA,
    description TEXT,
    FOREIGN KEY (myPlanetId) REFERENCES planets(id) ON DELETE CASCADE,
    CONSTRAINT name_length_check CHECK (LENGTH(name) <= 30),
    CONSTRAINT name_character_check CHECK (
        name ~ '^[a-zA-Z0-9_ -]+$'
    )
);

INSERT INTO moons (name, myPlanetId, image, description) VALUES ('Luna', 1, ?, 'My Home Planet Earth');
INSERT INTO moons (name, myPlanetId, image) VALUES ('Titan', 2, ?);
