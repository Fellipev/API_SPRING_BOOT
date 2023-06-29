create table medias(
    id bigint auto_increment primary key not null,
    id_usuario bigint not null,
    nota1 DECIMAL(4,2) not null,
    nota2 DECIMAL(4,2) not null,
    nota3 DECIMAL(4,2) not null,
    nota4 DECIMAL(4,2) not null,
    media DECIMAL(4,2) not null,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);