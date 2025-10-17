-- root wildflowers table
-- Assumption: wildflower has exactly ONE color and ONE zone 
CREATE TABLE wildflowers (
    wildflower_id INTEGER PRIMARY KEY AUTOINCREMENT,
    common_name VARCHAR(255) NOT NULL UNIQUE,
    scientific_name VARCHAR(255) NOT NULL UNIQUE,
    color_id INTEGER NOT NULL,
    zone_id INTEGER NOT NULL,
    bloom_start_date DATE NOT NULL,
    bloom_end_date DATE NOT NULL,
    image_url VARCHAR(512),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (color_id) REFERENCES colors(color_id),
    FOREIGN KEY (zone_id) REFERENCES elevational_zones(zone_id)
);

-- color lookup table
CREATE TABLE colors (
    color_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

-- elevational zones lookup table
CREATE TABLE elevational_zones (
    zone_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

-- TODO(b/XXXXX): add search indices