CREATE TABLE hebergements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    image_principale VARCHAR(255),
    prix_par_nuit DECIMAL(10, 2) NOT NULL
);

-- Insérer des exemples d'hébergements
INSERT INTO hebergements (type, nom, description, image_principale, prix_par_nuit)
VALUES
('Hotel', 'Hôtel Atlas', 'Un hôtel luxueux au cœur de la ville.', '/assets/img/hotel_atlas.jpg', 120.00),
('Appartement', 'Appartement Moderne', 'Appartement avec vue sur la mer.', '/assets/img/appartement_moderne.jpg', 80.00),
('MaisonHote', 'Maison d\'Hôtes Marrakech', 'Une maison d\'hôtes traditionnelle.', '/assets/img/maison_hotes.jpg', 100.00),
('Riad', 'Riad Andalou', 'Un riad authentique avec piscine.', '/assets/img/riad_andalou.jpg', 150.00);
