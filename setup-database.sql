-- Drop database if it exists and recreate it
DROP DATABASE IF EXISTS hebergementdb;
CREATE DATABASE hebergementdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hebergementdb;

-- Create the hebergements table
CREATE TABLE hebergements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    image_principale VARCHAR(255),
    prix_par_nuit DECIMAL(10, 2) NOT NULL
);

-- Insert sample data
INSERT INTO hebergements (type, nom, description, image_principale, prix_par_nuit)
VALUES
('Hotel', 'Hôtel Atlas', 'Un hôtel luxueux au cœur de la ville.', '/assets/img/hotel_atlas.jpg', 120.00),
('Appartement', 'Appartement Moderne', 'Appartement avec vue sur la mer.', '/assets/img/appartement_moderne.jpg', 80.00),
('MaisonHote', 'Maison d\'Hôtes Marrakech', 'Une maison d\'hôtes traditionnelle.', '/assets/img/maison_hotes.jpg', 100.00),
('Riad', 'Riad Andalou', 'Un riad authentique avec piscine.', '/assets/img/riad_andalou.jpg', 150.00);

-- Create a test user to verify permissions
CREATE USER IF NOT EXISTS 'testuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON hebergementdb.* TO 'testuser'@'localhost';
FLUSH PRIVILEGES;
