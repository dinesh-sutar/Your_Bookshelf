function OnRemove(id) {
    if (confirm("Do You Want To Remove ?")) {
        // location.href = "/remove-book?id="+id;
        location.href = `/remove-book?id=${id}`
    }
}