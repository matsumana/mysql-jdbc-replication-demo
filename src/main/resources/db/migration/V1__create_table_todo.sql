CREATE TABLE `todo` (
      `id` INT NOT NULL AUTO_INCREMENT
    , `title` VARCHAR(32) NOT NULL
    , `detail` VARCHAR(256)
    , `finished` tinyint(1) NOT NULL DEFAULT 0
    , PRIMARY KEY (id)
);
