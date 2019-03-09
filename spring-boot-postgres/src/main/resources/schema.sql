create table userdata (id integer,name text, score integer );
insert into userdata values('1','田中','100');
insert into userdata values('2','西村','90');

create table post (id integer, userid integer,content text );
insert into post values('1','1','sampleテキスト','sample1’);
insert into post values('2','1','sampleテキスト2','sample2');
insert into post values('3','1','sampleテキスト3','sample3');
insert into post values('4','2','sampleテキスト4','sample4');