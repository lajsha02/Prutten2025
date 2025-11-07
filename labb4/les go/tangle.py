import re 
import pathlib
import sys

src = pathlib.Path("labb4.lit.md").read_text(encoding="utf-8")
for m in re.finditer(r"```java file=([^\n]+)\n(.*?)```", src, flags=re.S):
    path = pathlib.Path(m.group(1)); path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(m.group(2), encoding="utf-8")
print("Tangling done.")
