function getPath(value) {
  return value === null ? 'api/hello' : `api/hello?name=${value}`;
}

function asTrimmedStringOrNull(actual) {
  if (typeof actual === 'undefined' || actual === null || '' === actual) {
    return null;
  }

  const actualAsString = actual + '';
  const trimmed = actualAsString.trim();

  return trimmed === '' ? null : trimmed;
}

export async function hello(name) {
  const value = asTrimmedStringOrNull(name);
  const path = getPath(value);

  const response = await fetch(path);

  if (response.status !== 200) {
    throw new Error('Failed to execute request.');
  }

  return await response.text();
}
