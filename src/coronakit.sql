-- this file contains the db script for
-- CoronaKit

DROP DATABASE coronakitDb;

CREATE DATABASE coronakitDb;

USE coronakitDb;

CREATE TABLE coronakititems (
productCode  int  primary key,
productName  varchar(450) not null,
productCost decimal not null,
productDescription varchar(1000) not null
);

CREATE TABLE coronaUserkititems (
productCode  int  primary key,
productName  varchar(450) not null,
productCost decimal not null,
productDescription varchar(1000) not null
);

CREATE TABLE `kitdetail` (
  `id` int(11) NOT NULL,
  `personName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contactNumber` varchar(45) DEFAULT NULL,
  `totalAmount` int(11) DEFAULT NULL,
  `deliveryAddress` varchar(45) DEFAULT NULL,
  `orderDate` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO coronakititems VALUES
(101, "SAFE+ N95 Pink 5 Layered Face Mask Pack of 1", 149, "Certified N95 Protection : Its an N95 mask tested as per WHO-GMP, EN149:2001, U.S. FDA standards in an ISO Certified lab."),
(102, "Braun BNT100 No Touch Infrared Thermometer (White)", 2499, "No-touch thermometer: this thermometer allows you to take clinically accurate readings without waking your sleeping child or adult. Measure temperatures on the forehead, an object or for bath water"),
(103, "Bildos 5 Layer N-95 mask washable mask with double Melt blown Layer - Pack of 5 (multi color)", 450, "At least 95% Filtering Efficiency Against Solid & Liquid Aerosols,Free of Oil
IN-BUILT NOSE PIN :In-built invisible metal nose pin which is more durable than ordinary glued pin on outer surface
Enhanced 5 layered filtration technique With Ultra Strong Protection: 5"),
(104, "Protection Face Shield Mask Isolation Mask Eyes Nose Full Frontal Protection Face Shield", 55, "Protect a larger portion of the face No impact on breathing resistance Very comfortable in wearing Can be disinfected easilyNo fit testing"),
(105, "OrchidsPlus Pro 2+ Layer Face Mask | Washable | Reusable - Pack of 5 (Grey)", 239,"Protection - 2+ Layers of Cotton Woven Fabric helps you cover your Nose, Chin & Mouth Washable & Reusable - The face masks are Hand Washable (Atleast 30 Washes or more) & reusable"),
(106, "mLabs Personal Protection Equipment Kit (PPE KIT)", 999, "Non-Woven Safety Suit with Head Cover 3 Ply Face Mask,Safety Goggles Head Cap,Disposable Bag Latex Gloves Shoe Cover"),
(107, "L.O.F Lords of Fashion PPE Kit 90 GSM WITH 2mm Acyrlic face shield", 549, "PPE Kit Contains:1 Pc .Body Suit attaches with Hood cover and shoes cover , 1 Pc Goggles, 1 Pc.3 Ply Face Mask, 1 Pair Gloves ,and 1 Pc disposable bag Offering Disposable Coverall to cover all body part to protect from Dust, Pollution etc."),
(108, "C9 Face Shields for Doctors, Virus Protection (Set of 100), Reusable, UV Sanitised, No Bare Human Touch",7000,"Face Shield for Virus Protection ,Full & wide Semi cylindrical Protection, Visor Thickness 300µm, transparent, excellent vision, Very comfortable to wear on different shape & size heads Specially designed shields restrict fog accumulation"),
(109, "Priyam 3 Ply Face Protective Mask with Transparent Shield for Men and Women (Pack 2 pcs only)",198,"Anti-fog lenses can maintain clarity and let your vision clear every moment. Unique design make it suitable for both men and women to wear"),
(110, "Life of Riley Health Safety Kit Reusable Anti Dust Mask Hand Gloves and Sanitizer (60ml) Pack of 3 Item",399,"Safety Kit Include: 1 PCS Reusable Face Mask, 1 PCS Sanitizer (60 ml) and Hand Gloves Set              The most stand-out feature of these gloves is that it is more obvious when a tear or puncture is made, protecting everyone involved."),
(111, "OPTIMA URBAN CRAFT Face Mask, Anti Pollution, and 2 Hand Sanitizer Bottles Gel and Liquid (100 ML x 2 Bottles) Killing", 249, "GET FORMULA, NOT LIQUID OR FOAM - Our fast acting 70% alcohol hand sanitizer has a gel consistency that dries in about 30 seconds        MULTI-FUNCTIONAL LIQUID - Our liquid hand sanitizer with alcohol is great to refill your pocket hand sanitizer spray bottles, use in larger spray bottles for cleaning surfaces, or filling a dispenser of any size in your home or business"),
(112, "NHR Combo Pack of 35 Surgical Mask 3 Ply Anti Pollution Face Mask and 2 Hand Sanitizer Bottles", 449, "ISO 9001:2015 certified 3 Ply Surgical Face Mask, Covers your nose, mouth, and chin and are disposable.                                                 Protects the wearer from sprays, splashes, and large-particle droplets. Prevent the spread of potentially infectious respiratory secretions from the wearer to others."),
(113, "Generic Electric Ultraviolet Uv Shoes Dryer Deodorizer Sterilizer Sanitizer Dehumidify", 9043, "Long life expectancy, low power consumption, waterproof/IP65. 2. UV technology kills 99.9% of germs, bacteria, viruses and fungi. 3. Environmentally safe, optimal design for high efficiency & high speed sterilization of shoes. 4. Ozone Sterilization: ozone from bulb spreads to all corner of the shoes cavity and causes the whole space sterilization"),
(114, "Colorsole Automatic Portable Mini Sanitizer Spray Machine For Currency, Car, Home, Office, Bank, Mobile Care Personal Care - Tank Capacity 30 ml", 349, "Mini sanitizer spray machine is ideal for Homes, Offices, Clinics, Hospitals, Schools, Banks, Courier Services, etc. This spray machine can be refilled and recharge, comes with a portable USB cable"),
(115, "KN-95 Ultrasonic 5 Layers Face Mask & Seabuck Healthy Hands Instant Hand Sanitizer (2 + 2)", 229, "2 KN-95 Masks & 2 Hand Sanitizers 5 Layers Face Mask, Ultrasonic face mask , with red loop & Smooth Breathing (comes with Filter for smooth breathing) , Soft & Comfortable"),
(116, "Organic Harvest Instant Gel Based Hand Sanitizer & Hand Cleanser with Organic Glycerin & Tea Tree Essential Oil, 70% Alcohol, Kills 99.9% Germs, 100ml (Pack of 3)", 150, "Organic Harvest Instant Gel Based Hand Sanitizer with 70% Alcohol, Tea Tree Essential Oil, Kills 99.9% Germs KEY INGREDIENTS: Anti-septic properties of Organic Tea Tree Essential Oil makes it a natural disinfectant. It helps in killing germs, while cleaning and soothing the skin."),
(117, "Himalaya Pure Hands | Hand Sanitizer - 500 ml (Lemon)", 225, "Protection on the go without soap kills 99.9% of germs without soap or water Keeps you and your family protected, anywhere and anytime"),
(118, "Cipla CIPHANDS DAILY DISINFECTNANT Spray 220ML", 242, "Kill 99.99% of the germs around you with this pocket/surface disinfectant. Easy to carry surface disinfectant effective against bacteria including tubercule bacillus, fungi, viruses including HBV and HIV Virus."),
(119, "Trycone Disinfectant Sanitizer Spray", 275, "Quality Product – It’s a premium quality product specially formulated and safe to use on skin and surfaces. Kills 99.99% Germs – It is efficient to kill 99.99% Germs and bacteria without water and keep you safe from all infections and viruses."),
(120, "Dot & Key Hand Cream : Sanitizer + moisturizer, with Mandarin & Lemon, alcohol free sanitizer plus hand cream for women and men - Paraben Free", 395, "2-in-1 Hand cream with moisturizing and sanitizing properties. Contains no nasty chemicals like alcohol, parabens, phthalates, making it 100% skin safe and gentle for daily use."),
(121, "AUTOPRO COVID Protection Detachable Plastic Cabin for Automobiles", 499, "HIGHLY TRANSPARENT HEAVY GSM EASY TO INSTALL & UNINSTALL NO DAMAGE TO INTERIOR WIPE CLEAN"),
(122, "KaaHego AM A COVID-19 Fighter Lets Keep Distance Vinyl Decal Sticker for Bumper Car Windows,Truck,Bike,Motorcycle(Size 19.5x11.5cm)_Yellow/Black",99, "Material Type:Vinyl And Poly Vinyl (Water resistance),Quantity: 1 // Size 19.5cm x11.5cm Stands Up Against Water, Dirt, Grease,Salt,Mild Acids And Oil Easy Install Easy Remove Water Resistance"),
(123, "Lifebuoy Laundry Sanitizer, 500 ml", 100, "A simple step of sanitization with Lifebuoy Laundry Sanitizer for ultra clean clothes post a detergent wash");

(`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (-184797480,'fsgdrfhg','[56, 57]','0',78,'ewewew','2020/08/30 21:15:02');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (883028677,'fsgdrfhg','[122, 123]','0',199,'ewewew','2020/08/30 21:17:02');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (768828522,'fsgdrfhg','[122, 123]','0',199,'ewewew','2020/08/30 21:19:36');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (1778146327,'fsgdrfhg','[122, 123]','0',199,'ewewew','2020/08/30 21:21:09');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (-2107889983,'fsdgdfh','[3, 55, 57]','4',139,'s2restdyhffh','2020/08/30 21:44:30');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (-1913006941,'test user 2','[3, 55]','5',360,'s2restdyhffh','2020/08/30 21:48:42');
INSERT INTO `` (`id`,`personName`,`email`,`contactNumber`,`totalAmount`,`deliveryAddress`,`orderDate`) VALUES (827231737,'lilly','[58, 101]','6',1032,'ewewew','2020/08/31 12:29:35');
