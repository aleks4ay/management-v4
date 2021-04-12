DROP TABLE IF EXISTS invoice_descr;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS manufacture;
DROP TABLE IF EXISTS descriptions;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS journal;
DROP TABLE IF EXISTS techno_item;
DROP TABLE IF EXISTS tmc;
DROP TABLE IF EXISTS embodiment;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS client;

DROP SEQUENCE IF EXISTS global_seq;
--
-- CREATE SEQUENCE global_seq START WITH 1000000;

CREATE TABLE client (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id CHARACTER VARYING(9) NOT NULL UNIQUE,
  name CHARACTER VARYING
);

CREATE TABLE worker (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id CHARACTER VARYING(9) NOT NULL UNIQUE,
  name CHARACTER VARYING
);

CREATE TABLE embodiment (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id CHARACTER VARYING(9) NOT NULL UNIQUE,
  description CHARACTER VARYING
);


CREATE TABLE tmc (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id CHARACTER VARYING(9) NOT NULL UNIQUE,
  id_parent CHARACTER VARYING(9),
  art CHARACTER VARYING(24),
  code CHARACTER VARYING(5),
  descr CHARACTER VARYING(50),
  is_folder INTEGER,
  size_a INTEGER,
  size_b INTEGER,
  size_c INTEGER,
  descr_all CHARACTER VARYING(100),
  type CHARACTER VARYING(9)
);

CREATE TABLE techno_item (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id_tmc CHARACTER VARYING(9) UNIQUE,
  store_c INTEGER DEFAULT 0,
  period TIMESTAMP WITHOUT TIME ZONE,
  FOREIGN KEY (id_tmc) REFERENCES tmc (id) ON DELETE CASCADE
);

CREATE TABLE journal (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  iddoc      CHARACTER VARYING(9) NOT NULL UNIQUE,
  docno      CHARACTER VARYING(10),
  datecreate TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE orders (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  iddoc CHARACTER VARYING(9) NOT NULL UNIQUE,
  id_client CHARACTER VARYING(9),
  id_manager CHARACTER VARYING(9),
  duration INTEGER,
  t_factory TIMESTAMP WITHOUT TIME ZONE,
  price NUMERIC(14,3),
  FOREIGN KEY (id_client) REFERENCES client (id) ON DELETE CASCADE,
  FOREIGN KEY (id_manager) REFERENCES worker (id) ON DELETE CASCADE,
  FOREIGN KEY (iddoc) REFERENCES journal (iddoc) ON DELETE CASCADE
);

CREATE TABLE descriptions (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  iddoc CHARACTER VARYING(9),
  position INTEGER,
  id_tmc CHARACTER VARYING(9),
  quantity INTEGER,
  descr_second CHARACTER VARYING(300),
  size_a INTEGER,
  size_b INTEGER,
  size_c INTEGER,
  id_embodiment CHARACTER VARYING(9),
  price NUMERIC(14,3),
  FOREIGN KEY (iddoc) REFERENCES orders (iddoc) ON DELETE CASCADE,
  FOREIGN KEY (id_tmc) REFERENCES tmc (id) ON DELETE CASCADE,
  FOREIGN KEY (id_embodiment) REFERENCES embodiment (id) ON DELETE CASCADE
);

CREATE TABLE manufacture (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  iddoc CHARACTER VARYING(9),
  id_order CHARACTER VARYING(9),
  position INTEGER,
  quantity INTEGER,
  id_tmc CHARACTER VARYING(9),
  descr_second CHARACTER VARYING,
  size_a INTEGER,
  size_b INTEGER,
  size_c INTEGER,
  embodiment CHARACTER VARYING(9),
  FOREIGN KEY (iddoc) REFERENCES journal (iddoc) ON DELETE CASCADE,
  FOREIGN KEY (id_order) REFERENCES orders (iddoc) ON DELETE CASCADE,
  FOREIGN KEY (id_tmc) REFERENCES tmc (id) ON DELETE CASCADE
);

CREATE TABLE invoice (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  iddoc CHARACTER VARYING(9) NOT NULL UNIQUE,
  id_order CHARACTER VARYING(9),
  price NUMERIC(14,3),
  FOREIGN KEY (iddoc) REFERENCES journal (iddoc) ON DELETE CASCADE,
  FOREIGN KEY (id_order) REFERENCES orders (iddoc) ON DELETE CASCADE
);

CREATE TABLE invoice_descr (
  auto_id    BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  id_invoice CHARACTER VARYING(9),
  id_tmc CHARACTER VARYING(9),
  position INTEGER,
  quantity INTEGER,
  payment NUMERIC(14,3),
  FOREIGN KEY (id_invoice) REFERENCES invoice (iddoc) ON DELETE CASCADE,
  FOREIGN KEY (id_tmc) REFERENCES tmc (id) ON DELETE CASCADE
);


CREATE VIEW order_view (
    iddoc, docno, datecreate, id_client, id_manager, duration, t_factory, price, client, manager
)
AS SELECT
     j.iddoc, j.docno ,j.datecreate,o.id_client, o.id_manager, o.duration, o.t_factory, o.price, c.name, w.name
   from orders o
     LEFT JOIN journal j ON o.iddoc = j.iddoc
     LEFT JOIN client c ON o.id_client = c.id
     LEFT JOIN worker w ON o.id_manager = w.id
   ORDER BY j.iddoc;