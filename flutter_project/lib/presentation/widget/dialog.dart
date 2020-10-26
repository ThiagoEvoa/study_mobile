import 'package:flutter/material.dart';

Future<void> dialog({@required BuildContext context, @required String title, @required String message}) async {
  return showDialog(
    context: context,
    barrierDismissible: false,
    builder: (context) {
      return AlertDialog(
        title: Text(title),
        content: Text(message),
        actions: <Widget>[
          FlatButton(
            onPressed: () {
              Navigator.of(context).pop();
            },
            child: Text("ok"),
          )
        ],
      );
    },
  );
}
