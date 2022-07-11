PGDMP         %                z            postgres    14.4    14.4 "    %           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            &           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            '           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            (           1262    14021    postgres    DATABASE     ]   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE postgres;
                postgres    false            )           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3624            �            1259    16607    tb_email_id_email_seq    SEQUENCE     ~   CREATE SEQUENCE public.tb_email_id_email_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tb_email_id_email_seq;
       public          postgres    false            �            1259    16637    tb_email    TABLE     �   CREATE TABLE public.tb_email (
    id_email integer DEFAULT nextval('public.tb_email_id_email_seq'::regclass) NOT NULL,
    id_usuario integer,
    ds_email character varying(100)
);
    DROP TABLE public.tb_email;
       public         heap    postgres    false    212            �            1259    16605    tb_endereco_id_endereco_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_endereco_id_endereco_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.tb_endereco_id_endereco_seq;
       public          postgres    false            �            1259    16621    tb_endereco    TABLE     �  CREATE TABLE public.tb_endereco (
    id_endereco integer DEFAULT nextval('public.tb_endereco_id_endereco_seq'::regclass) NOT NULL,
    id_usuario integer,
    nu_cep character varying(8) NOT NULL,
    ds_logradouro character varying NOT NULL,
    ds_bairro character varying NOT NULL,
    ds_cidade character varying NOT NULL,
    ds_uf character varying(2) NOT NULL,
    ds_complemento character varying
);
    DROP TABLE public.tb_endereco;
       public         heap    postgres    false    210            �            1259    16618 	   tb_perfil    TABLE     n   CREATE TABLE public.tb_perfil (
    id_perfil integer NOT NULL,
    ds_role character varying(50) NOT NULL
);
    DROP TABLE public.tb_perfil;
       public         heap    postgres    false            �            1259    16606    tb_telefone_id_telefone_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_telefone_id_telefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.tb_telefone_id_telefone_seq;
       public          postgres    false            �            1259    16629    tb_telefone    TABLE     �   CREATE TABLE public.tb_telefone (
    id_telefone integer DEFAULT nextval('public.tb_telefone_id_telefone_seq'::regclass) NOT NULL,
    id_usuario integer,
    no_telefone character varying(11),
    ds_tipo character varying
);
    DROP TABLE public.tb_telefone;
       public         heap    postgres    false    211            �            1259    16604    tb_usuario_id_usuario_sq    SEQUENCE     �   CREATE SEQUENCE public.tb_usuario_id_usuario_sq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tb_usuario_id_usuario_sq;
       public          postgres    false            �            1259    16608 
   tb_usuario    TABLE     (  CREATE TABLE public.tb_usuario (
    id_usuario integer DEFAULT nextval('public.tb_usuario_id_usuario_sq'::regclass) NOT NULL,
    no_usuario character varying(100) NOT NULL,
    ds_senha character varying,
    nu_cpf character varying NOT NULL,
    id_perfil integer,
    id_endereco integer
);
    DROP TABLE public.tb_usuario;
       public         heap    postgres    false    209            "          0    16637    tb_email 
   TABLE DATA           B   COPY public.tb_email (id_email, id_usuario, ds_email) FROM stdin;
    public          postgres    false    217   �(                  0    16621    tb_endereco 
   TABLE DATA           �   COPY public.tb_endereco (id_endereco, id_usuario, nu_cep, ds_logradouro, ds_bairro, ds_cidade, ds_uf, ds_complemento) FROM stdin;
    public          postgres    false    215   )                 0    16618 	   tb_perfil 
   TABLE DATA           7   COPY public.tb_perfil (id_perfil, ds_role) FROM stdin;
    public          postgres    false    214   �)       !          0    16629    tb_telefone 
   TABLE DATA           T   COPY public.tb_telefone (id_telefone, id_usuario, no_telefone, ds_tipo) FROM stdin;
    public          postgres    false    216   �)                 0    16608 
   tb_usuario 
   TABLE DATA           f   COPY public.tb_usuario (id_usuario, no_usuario, ds_senha, nu_cpf, id_perfil, id_endereco) FROM stdin;
    public          postgres    false    213   :*       *           0    0    tb_email_id_email_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.tb_email_id_email_seq', 8, true);
          public          postgres    false    212            +           0    0    tb_endereco_id_endereco_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.tb_endereco_id_endereco_seq', 9, true);
          public          postgres    false    210            ,           0    0    tb_telefone_id_telefone_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.tb_telefone_id_telefone_seq', 6, true);
          public          postgres    false    211            -           0    0    tb_usuario_id_usuario_sq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tb_usuario_id_usuario_sq', 2, true);
          public          postgres    false    209            �           2606    16642    tb_email id_email 
   CONSTRAINT     U   ALTER TABLE ONLY public.tb_email
    ADD CONSTRAINT id_email PRIMARY KEY (id_email);
 ;   ALTER TABLE ONLY public.tb_email DROP CONSTRAINT id_email;
       public            postgres    false    217            �           2606    16628    tb_endereco id_endereco 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT id_endereco PRIMARY KEY (id_endereco);
 A   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT id_endereco;
       public            postgres    false    215            �           2606    16655    tb_perfil id_perfil 
   CONSTRAINT     X   ALTER TABLE ONLY public.tb_perfil
    ADD CONSTRAINT id_perfil PRIMARY KEY (id_perfil);
 =   ALTER TABLE ONLY public.tb_perfil DROP CONSTRAINT id_perfil;
       public            postgres    false    214            �           2606    16636    tb_telefone id_telefone 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tb_telefone
    ADD CONSTRAINT id_telefone PRIMARY KEY (id_telefone);
 A   ALTER TABLE ONLY public.tb_telefone DROP CONSTRAINT id_telefone;
       public            postgres    false    216                       2606    16615    tb_usuario id_usuario 
   CONSTRAINT     [   ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT id_usuario PRIMARY KEY (id_usuario);
 ?   ALTER TABLE ONLY public.tb_usuario DROP CONSTRAINT id_usuario;
       public            postgres    false    213            �           2606    16617     tb_usuario tb_usuario_cpf_unique 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_cpf_unique UNIQUE (nu_cpf);
 J   ALTER TABLE ONLY public.tb_usuario DROP CONSTRAINT tb_usuario_cpf_unique;
       public            postgres    false    213            �           2606    16701    tb_email tb_email_id_usuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_email
    ADD CONSTRAINT tb_email_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.tb_usuario(id_usuario);
 I   ALTER TABLE ONLY public.tb_email DROP CONSTRAINT tb_email_id_usuario_fk;
       public          postgres    false    217    213    3455            �           2606    16696 %   tb_endereco tb_endereco_id_usuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT tb_endereco_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.tb_usuario(id_usuario);
 O   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT tb_endereco_id_usuario_fk;
       public          postgres    false    215    213    3455            �           2606    16691 %   tb_telefone tb_telefone_id_usuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_telefone
    ADD CONSTRAINT tb_telefone_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.tb_usuario(id_usuario);
 O   ALTER TABLE ONLY public.tb_telefone DROP CONSTRAINT tb_telefone_id_usuario_fk;
       public          postgres    false    213    216    3455            �           2606    16706 $   tb_usuario tb_usuario_id_endereco_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_id_endereco_fk FOREIGN KEY (id_endereco) REFERENCES public.tb_endereco(id_endereco);
 N   ALTER TABLE ONLY public.tb_usuario DROP CONSTRAINT tb_usuario_id_endereco_fk;
       public          postgres    false    215    3461    213            �           2606    16681 "   tb_usuario tb_usuario_id_perfil_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_id_perfil_fk FOREIGN KEY (id_perfil) REFERENCES public.tb_perfil(id_perfil);
 L   ALTER TABLE ONLY public.tb_usuario DROP CONSTRAINT tb_usuario_id_perfil_fk;
       public          postgres    false    3459    214    213            "   i   x�3�4�,)JLJ���wHL����K���2�4BJs�¦ թ�%�����9`1c��Ē�Ĝ̪�"$�f�1~�e��
��%\�@�@�1�g�³��L �=... ?�-�          u   x�m�A
�0F��?��H�R�n"R!d㶛 ��#M��)��������b�,�s�v3�Z�l[W���ϻ>
Ng,�/�;��p�/��SNֵ� ������W�U��x?��r �/G.%�            x�3�LL����2�,-N-����� : �      !   _   x�M�K
�0C�3��6�ع�)]���;PY$!�(Z�d�1�K����?}��򱗖��2Ȏ�JD~�}��y�������셣������7_d         E   x�3���O�WHI,V�K-K-�442615Qda�i�i�e��Z���R����X����̜ӐӐ+F��� p��     