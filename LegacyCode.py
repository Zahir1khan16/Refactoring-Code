from pathlib import Path


def read_numbers(file_path: str) -> list[int]:
    """Read integers from a file and return them as a list."""
    numbers = []

    try:
        with open(file_path, "r") as f:
            for line in f:
                line = line.strip()
                if line:  # ignore empty lines
                    numbers.append(int(line))
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
    except ValueError as e:
        print(f"Invalid number in file: {e}")

    return numbers


def compute_statistics(numbers: list[int]) -> dict:
    """Compute statistics from a list of numbers."""
    if not numbers:
        return {}

    total = len(numbers)
    summation = sum(numbers)
    average = round(summation / total)

    return {
        "total": total,
        "summation": summation,
        "average": average,
        "minimum": min(numbers),
        "maximum": max(numbers),
    }


def print_statistics(stats: dict) -> None:
    """Display statistics."""
    if not stats:
        print("No statistics available.")
        return

    print(f"total = {stats['total']}")
    print(f"summation = {stats['summation']}")
    print(f"average = {stats['average']}")
    print(f"Minimum = {stats['minimum']}")
    print(f"Maximum = {stats['maximum']}")


def main():
    file_name = "random_nums.txt"
    numbers = read_numbers(file_name)
    stats = compute_statistics(numbers)
    print_statistics(stats)


if __name__ == "__main__":
    main()