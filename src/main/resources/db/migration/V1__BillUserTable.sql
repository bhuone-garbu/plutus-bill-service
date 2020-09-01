-- this is a postgres implementation
-- if uuid generate extension needs to be created
create extension if not exists "uuid-ossp";

create table if not exists "user" (
  id uuid not null primary key default uuid_generate_v4(),
  username varchar not null unique,
  email varchar not null unique,
  mobile_no varchar not null,
  registered_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);

create table if not exists "bill" (
  id bigserial not null primary key,
  description varchar not null,
  amount numeric(6, 2) not null,
  created_by uuid not null references "user"(id),
  paid_by uuid not null references "user"(id),
  is_paid boolean default false,
  is_deleted boolean default false,
  bill_created_at timestamp not null default current_timestamp,
  bill_updated_at timestamp not null default current_timestamp
);
