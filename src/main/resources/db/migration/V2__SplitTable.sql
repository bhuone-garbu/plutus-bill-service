create table if not exists "split" (
  id uuid not null primary key default uuid_generate_v4(),
  recipient uuid not null references "user"(id),
  bill bigserial not null references bill(id),
  amount numeric(6,2) not null,
  is_paid boolean not null default false
)