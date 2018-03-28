CREATE TABLE category(
id IDENTITY,
name VARCHAR(400),
description VARCHAR(400),
image_url VARCHAR(400),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)

);