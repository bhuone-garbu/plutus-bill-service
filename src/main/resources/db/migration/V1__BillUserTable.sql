create table AppUser (
  id uuid not null primary key,
  username varchar not null,
  email varchar not null,
  mobileNo varchar not null,
  registeredAt timestamp not null,
  updatedAt timestamp not null
);

create table Bill (
  id uuid not null primary key,
  description varchar not null,
  amount numeric(6, 2) not null,
  paidByUser uuid references AppUser(id),
  isPaid boolean default false,
  isDeleted boolean default false
);
