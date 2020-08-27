create table if not exists  app_user (
  id uuid not null primary key,
  username varchar not null,
  email varchar not null,
  mobile_no varchar not null,
  registered_at timestamp not null,
  updated_at timestamp not null
);

create table if not exists bill (
  id uuid not null primary key,
  description varchar not null,
  amount numeric(6, 2) not null,
  paid_by_user uuid references app_user(id),
  is_paid boolean default false,
  is_deleted boolean default false
);
